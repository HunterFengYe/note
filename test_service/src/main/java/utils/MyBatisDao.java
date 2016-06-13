package utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ±êÊ¶MyBatisµÄDAO
 * 
 * @author HeHongxin
 * @date 2015-4-29
 * @see {@link org.mybatis.spring.mapper.MapperScannerConfigurer}
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyBatisDao {

	String value() default "";
}

