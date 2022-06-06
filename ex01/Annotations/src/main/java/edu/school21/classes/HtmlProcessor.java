package edu.school21.classes;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"edu.school21.classes.HtmlForm", "edu.school21.classes.HtmlInput"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HtmlProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {

        for (TypeElement annotation : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
                
                String name = e.getSimpleName().toString();
                try {
                    File file = new File(name);
                    file.createNewFile();
                    BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(file));
                    bufferedWriter.write("Hello", 0, 5);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }

        }

        return true;
    }
}
