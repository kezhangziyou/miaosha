package com.imooc.miaosha.validator;
import  javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.imooc.miaosha.util.ValidatorUtil;
/**
 * @description  看到这个注解调用这个校验器
 * @author zhangke
 * @date 3:32 PM 2019/12/9
 * @version 1.0
 **/
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required = false;

	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return ValidatorUtil.isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return ValidatorUtil.isMobile(value);
			}
		}
	}

}
