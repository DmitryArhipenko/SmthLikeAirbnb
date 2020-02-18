//package com.validator;
//
//import com.model.Advertisment;
//import com.service.AdvertismentService;
//import com.service.AdvertismentServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class AdvertismentValidator implements Validator {
//    @Autowired
//    private AdvertismentServiceImpl advertismentService;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Advertisment.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Advertisment advertisment = (Advertisment) o;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
//        if (advertismentService.findAdvertismentByTitle(advertisment.getTitle()) != null) {
//            errors.rejectValue("title", "Duplicate.title");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apartmentType", "NotEmpty");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "square", "NotEmpty");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
//    }
//}