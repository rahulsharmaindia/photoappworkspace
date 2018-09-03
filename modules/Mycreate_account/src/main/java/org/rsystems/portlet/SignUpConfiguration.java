package org.rsystems.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.example.login.portlet.SignUpConfiguration")
public interface SignUpConfiguration {

	
    @Meta.AD(required = false)
    public String userOrganization();
    @Meta.AD(required = false)
    public String userRole();
    @Meta.AD(required = false)
    public String redirectURL();

}