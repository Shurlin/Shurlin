package annotations;

import annotations.meta.TypeQualifierNickname;
import annotations.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@TypeQualifierNickname
@Untainted(when = When.MAYBE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tainted {

}
