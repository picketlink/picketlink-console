/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.picketlink.as.console.client.shared.subsys.model;

/**
 * <p>Enum defining alias for each supported built-in {@link org.picketlink.idm.credential.handler.CredentialHandler} provided by
 * PicketLink. The alias is used in the configuration without using the full qualified name of a type.</p>
 *
 * @author Pedro Igor
 */
public enum HandlerTypeEnum {

    // handlers
    SAML2_ISSUER_TRUST_HANDLER("SAML2IssuerTrustHandler"),
    SAML2_AUTHENTICATION_HANDLER("SAML2AuthenticationHandler"),
    ROLES_GENERATION_HANDLER("RolesGenerationHandler"),
    SAML2_ATTRIBUTE_HANDLER("SAML2AttributeHandler"),
    SAML2_ENCRYPTION_HANDLER("SAML2EncryptionHandler"),
    SAML2_IN_RESPONSE_VERIFICATION_HANDLER("SAML2InResponseToVerificationHandler"),
    SAML2_LOGOUT_HANDLER("SAML2LogOutHandler"),
    SAML2_SIGNATURE_GENERATION_HANDLER("SAML2SignatureGenerationHandler"),
    SAML2_SIGNATURE_VALIDATION_HANDLER("SAML2SignatureValidationHandler");


    private final String alias;

    private HandlerTypeEnum(String alias) {
        this.alias = alias;
    }

    public static HandlerTypeEnum find(String alias) {
        for (HandlerTypeEnum type : values()) {
            if (type.getAlias().equals(alias)) {
                return type;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.alias;
    }

    public String getAlias() {
        return this.alias;
    }
}
