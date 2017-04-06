/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 * Most of this is "inspired" by a stackoverflow example on making a custom
 * password confirmation validator.
 * http://stackoverflow.com/questions/7489893/how-validate-two-password-fields-by-ajax
 * 
 * This is also a bit of a hack because validators can't actually inject
 * due to an oversight that isn't fixed, so I dunno it's crazy.
 *
 * @author c0538434
 */
@RequestScoped
@ManagedBean
public class RegisterValidator implements Validator {

    @Inject
    private UserList ul;

    @Override
    public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;
        String password = (String) component.getAttributes().get("password");
        String confirm = (String) component.getAttributes().get("confirm");

        if (ul.userExistsByEmail(email)) {
            throw new ValidatorException(new FacesMessage("That email is already in use"));
        }

        if (password == null || confirm == null) {
            return;
        }

        if (!password.equals(confirm)) {
            throw new ValidatorException(new FacesMessage("Passwords do not match."));
        }
    }
}
