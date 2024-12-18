package reusableComponents;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class Retryannotation implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstrocter, Method testMetod) {
		annotation.setRetryAnalyzer(Rerunautomationscript.class);
		
	}
}
