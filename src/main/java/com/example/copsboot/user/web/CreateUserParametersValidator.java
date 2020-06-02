package com.example.copsboot.user.web;

import com.example.copsboot.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateUserParametersValidator implements ConstraintValidator<ValidCreateUserParameters, CreateOfficerParameters> {

    private final UserService userService;

    @Autowired
    public CreateUserParametersValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidCreateUserParameters constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateOfficerParameters userParameters, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;

        if (userService.findUserByEmail(userParameters.getEmail()).isPresent()) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("There is already a user with the given email address.")
                    .addPropertyNode("email").addConstraintViolation();
            result = false;
        }

        return result;
    }
}
