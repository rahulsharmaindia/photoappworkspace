package org.rsystems.portlet;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.liferay.portal.kernel.model.User;

public class LDAPService {
	private static final String AD_ATTR_NAME_USER_EMAIL = "mail";

	/**
	 * 
	 * @param ctx
	 * @param searchBase
	 * @param domainWithUser:
	 *            such as "MYDOMAIN\myUser"
	 * @return
	 */
	public String updateUserPassword(LdapContext ctx, String searchBase, User user, String password) {
		try {
			String userName = user.getScreenName();			
			NamingEnumeration<SearchResult> userData = getUserData(ctx, searchBase, userName);
			/**
			 * In case of LIFERAY DXP CE GA4 user not automatically added to
			 * LDAP by calling method:
			 * com.liferay.portal.kernel.service.UserService.addUserWithWorkflow
			 * Below code skipped in case of LIFERAY DXP CE GA3.
			 */
			if (userData != null && userData.hasMoreElements()) {

				SearchResult sr = userData.next();
				Attributes atrs = sr.getAttributes();
				Attribute atr = atrs.get("cn");
				if (!userName.equalsIgnoreCase((String) atr.get())) {
					createLdapUser(ctx, user, password);
				}

			} else {
				createLdapUser(ctx, user, password);
			}

			/**
			 *  updating the record
			 */
			Attribute attribute = new BasicAttribute("userPassword", password);
			/**
			 *  array of modified iteams
			 */
			ModificationItem[] item = new ModificationItem[1];
			/**
			 *  replacing the value
			 */
			item[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, attribute);
			
			//createLdapUser(ctx, searchBase, userName, password);
			/**
			 *  changing the value of the attribute
			 */			
			ctx.modifyAttributes("CN=" + userName + " ,DC=Example,DC=com", item);
			
			System.out.println("LDAP modified the user with new password");
			return "success";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * Method will add user to Ldap directory.
	 *  
	 * @param ctx
	 * @param user
	 * @param password
	 * @return
	 */
	public String createLdapUser(LdapContext ctx, User user, String password) {		
		
		String userId = user.getScreenName();
		String lName = user.getLastName();
		String fName = user.getFirstName();
		String emailId = user.getEmailAddress();
		Attributes container = new BasicAttributes();

		// Create the objectclass to add
		Attribute objClasses = new BasicAttribute("objectClass");
		objClasses.add("inetOrgPerson");
		// Assign the username, first name, and last name
		Attribute commonName = new BasicAttribute("cn", userId);
		Attribute email = new BasicAttribute("mail", emailId);
		Attribute givenName = new BasicAttribute("givenName", fName + lName);
		Attribute surName = new BasicAttribute("sn", lName);

		// Add password
		Attribute userPassword = new BasicAttribute("userpassword", password);

		// Add these to the container
		container.put(objClasses);
		container.put(commonName);
		container.put(givenName);
		container.put(email);
		container.put(surName);
		container.put(userPassword);

		// Create the entry
		try {
			ctx.createSubcontext(getUserDN(userId), container);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * Method will return concatenated DN.
	 * 
	 * @param userName
	 * @return
	 */
	private String getUserDN( String userName) {
		String userDN = new StringBuffer().append("cn=").append(userName).append(",dc=example,dc=com").toString();
		System.out.println(userDN);
		return userDN;
	}
	private NamingEnumeration<SearchResult> getUserData(LdapContext ctx, String searchBase, String username)
			throws Exception {
		String filter = "(&(&(objectClass=inetOrgPerson))(cn=" + username + "))";
		SearchControls searchCtls = new SearchControls();
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		NamingEnumeration<SearchResult> answer = null;
		try {
			answer = ctx.search(searchBase, filter, searchCtls);
		} catch (Exception e) {
			System.out.println("Error searching Active directory for " + filter);
			throw e;
		}

		return answer;
	}

	private String getUserMailFromSearchResults(NamingEnumeration<SearchResult> userData) throws Exception {
		try {
			String mail = null;
			/**
			 *  getting only the first result if we have more than one
			 */
			if (userData.hasMoreElements()) {
				SearchResult sr = userData.nextElement();
				Attributes attributes = sr.getAttributes();
				mail = attributes.get(AD_ATTR_NAME_USER_EMAIL).get().toString();
				System.out.println("found email " + mail);
			}

			return mail;
		} catch (Exception e) {
			System.out.println("Error fetching attribute from object");
			throw e;
		}
	}
}
