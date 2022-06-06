package edu.school21.classes;

import sun.reflect.annotation.AnnotationType;

import java.text.Annotation;

@interface HtmlForm {

    String fileName();

    String action();

    String method();
}
