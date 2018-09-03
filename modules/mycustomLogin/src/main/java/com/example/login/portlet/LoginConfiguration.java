package com.example.login.portlet;

import aQute.bnd.annotation.metatype.Meta;

//@ExtendedObjectClassDefinition(
//	    category = "productivity", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
//	)
@Meta.OCD(id = "com.example.login.portlet.LoginConfiguration")
public interface LoginConfiguration {

	
    @Meta.AD(required = false)
    public String redirectURL();

}