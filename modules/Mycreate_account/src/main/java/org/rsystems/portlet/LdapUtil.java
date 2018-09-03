/*package org.rsystems.portlet;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.ldap.LdapContext;

import com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration;

public class LdapUtil {
	public static void update(LDAPServerConfiguration configuration, String userName) throws Exception {
		String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
		String MY_HOST = configuration.baseProviderURL();
		String MGR_DN = "cn="+userName+configuration.baseDN();
		String MGR_PW = configuration.securityCredential();
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
		env.put(Context.PROVIDER_URL, MY_HOST);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, MGR_DN);
		env.put(Context.SECURITY_CREDENTIALS, MGR_PW);

		DirContext ctx = new InitialDirContext(env);

		ModificationItem[] mods = new ModificationItem[2];

		Attribute mod0 = new BasicAttribute("number", "555-555-5555");
		Attribute mod1 = new BasicAttribute("1", "AAA");

		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
		mods[1] = new ModificationItem(DirContext.ADD_ATTRIBUTE, mod1);

		ctx.modifyAttributes("uid=mewilcox, ou=People, o=airius.com", mods);
	}
	
	public static void main(String[] args) {
		LdapContext ctx  = LDAPConnectionUtils.createContext("ldap://localhost:10389","uid=admin,ou=system","secret");
		LDAPService ldapService= new LDAPService();
		ldapService.updateUserPassword(ctx, "dc=example,dc=com", "bjhgjhgjhg","password");
	}

}
*/