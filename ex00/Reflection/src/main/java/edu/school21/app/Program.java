package edu.school21.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Program {

    public static String transform(String typeName) {
        if (typeName.contains("."))
            typeName = typeName.substring(typeName.lastIndexOf('.') + 1, typeName.length());
        return typeName;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Classes:\nUser\nCar");
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        Scanner scanner = new Scanner(System.in);
        Class c = null;
        try {
           c = Class.forName("edu.school21.classes." + scanner.next());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("---------------------");
        System.out.println("fields :");
        Field fields[] = c.getDeclaredFields();
        for (Field field : fields) {
            String typeName = field.getType().getName();
            if ( typeName.contains(".") )
                typeName = typeName.substring(typeName.lastIndexOf('.') + 1, typeName.length());
            System.out.println("\t" + typeName + " " + field.getName());
        }
        System.out.println("methods :");
        Method methods[] = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("toString"))
                continue;
            System.out.print("\t" + method.getReturnType() + " " + method.getName() + "(");
            Class parameters[] = method.getParameterTypes();
            for (int i = 0; i < parameters.length; i++) {
                String typeName = parameters[i].getName();
                if ( typeName.contains(".") )
                    typeName = typeName.substring(typeName.lastIndexOf('.') + 1, typeName.length());
                System.out.print(parameters[i]);
                if (i < parameters.length - 1)
                    System.out.print(",");
            }
            System.out.println(")");
        }

        System.out.println("---------------------");
        System.out.println("Let's create an object.");
        Constructor constructors[] = c.getDeclaredConstructors();
        Class parametersTypes[] = null;

        for (Constructor constructor : constructors) {
            if (constructor.getParameterTypes().length > 0) {
                parametersTypes = constructor.getParameterTypes();
            }
        }
        Constructor constructor = null;
        try {
            constructor = c.getConstructor(parametersTypes);
        } catch (Exception e) {
            System.out.println(e);
        }
        Object argArray[] = new Object[parametersTypes.length];
        for (int i = 0; i < argArray.length; i++) {
            System.out.println(fields[i].getName() + ":");
            String typeName = parametersTypes[i].getName();
            if ( typeName.contains(".") )
                typeName = typeName.substring(typeName.lastIndexOf('.') + 1, typeName.length());
            if (typeName.equals("Integer") || typeName.equals("int") ) {
                argArray[i] = scanner.nextInt();
            } else if (typeName.equals("Float") || typeName.equals("float")) {
                argArray[i] = scanner.nextFloat();
            } else if (typeName.equals("String")) {
                argArray[i] = scanner.next();
            } else if (typeName.equals("Double") || typeName.equals("double")) {
                argArray[i] = scanner.nextDouble();
            } else if (typeName.equals("Boolean") || typeName.equals("bool")) {
                argArray[i] = scanner.nextBoolean();
            } else if (typeName.equals("BigInteger")) {
                argArray[i] = scanner.nextBigInteger();
            } else if (typeName.equals("Long") || typeName.equals("long")) {
                argArray[i] = scanner.nextLong();
            } else if (typeName.equals("Short") || typeName.equals("short")) {
                argArray[i] = scanner.nextShort();
            } else if (typeName.equals("Byte") || typeName.equals("byte")) {
                argArray[i] = scanner.nextByte();
            } else if (typeName.equals("BigDecimal")) {
                argArray[i] = scanner.nextBigDecimal();
            }
        }

        Object object = null;
        try {
            object = constructor.newInstance(argArray);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.print("Object created: ");
        System.out.println(object.toString());

        System.out.println("---------------------");
        System.out.println("Enter name of the field for changing:");
        String fieldName = scanner.next();
        Field field = c.getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.println("Enter " + transform(field.getType().getName()) + " value:");

        String typeName = transform(field.getType().getName());
        if (typeName.equals("Integer") || typeName.equals("int") ) {
            field.set(object, scanner.nextInt());
        } else if (typeName.equals("Float") || typeName.equals("float")) {
            field.set(object, scanner.nextFloat());
        } else if (typeName.equals("String")) {
            field.set(object, scanner.next());
        } else if (typeName.equals("Double") || typeName.equals("double")) {
            field.set(object, scanner.nextDouble());
        } else if (typeName.equals("Boolean") || typeName.equals("bool")) {
            field.set(object, scanner.nextBoolean());
        } else if (typeName.equals("BigInteger")) {
            field.set(object, scanner.nextBigInteger());
        } else if (typeName.equals("Long") || typeName.equals("long")) {
            field.set(object, scanner.nextLong());
        } else if (typeName.equals("Short") || typeName.equals("short")) {
            field.set(object, scanner.nextShort());
        } else if (typeName.equals("Byte") || typeName.equals("byte")) {
            field.set(object, scanner.nextByte());
        } else if (typeName.equals("BigDecimal")) {
            field.set(object, scanner.nextBigDecimal());
        }
        System.out.print("Object updated: ");
        System.out.println(object.toString());
        System.out.println("---------------------");

        System.out.println("Enter name of the method for call:");
        String methodLine = scanner.next();
        String methodName = methodLine.substring(0, methodLine.indexOf('('));
        String argsNamesLine = methodLine.substring(methodLine.indexOf("(") + 1, methodLine.indexOf(')'));
        Object [] argTypes;
        if (!argsNamesLine.contains(","))
            argTypes = new Object[0];
        String [] argsNames = argsNamesLine.split(",");
        Class methodTypes[] = new Class[argsNames.length];
        argTypes = new Object[argsNames.length];
        int i = 0;
        for (String argName : argsNames) {
            typeName = argName;
            System.out.println("Enter " + argName + " value:");
            if (typeName.equals("Integer") || typeName.equals("int") ) {
                methodTypes[i] = Integer.TYPE;
                argTypes[i] = scanner.nextInt();
            } else if (typeName.equals("Float") || typeName.equals("float")) {
                methodTypes[i] = Float.TYPE;
                argTypes[i] = scanner.nextFloat();
            } else if (typeName.equals("String")) {
                methodTypes[i] = String.class;
                argTypes[i] = scanner.next();
            } else if (typeName.equals("Double") || typeName.equals("double")) {
                methodTypes[i] = Double.class;
                argTypes[i] = scanner.nextDouble();
            } else if (typeName.equals("Boolean") || typeName.equals("bool")) {
                methodTypes[i] = Boolean.TYPE;
                argTypes[i] = scanner.nextBoolean();
            } else if (typeName.equals("BigInteger")) {
                methodTypes[i] = BigInteger.class;
                argTypes[i] = scanner.nextBigInteger();
            } else if (typeName.equals("Long") || typeName.equals("long")) {
                methodTypes[i] = Long.TYPE;
                argTypes[i] = scanner.nextLong();
            } else if (typeName.equals("Short") || typeName.equals("short")) {
                methodTypes[i] = Short.TYPE;
                argTypes[i] = scanner.nextShort();
            } else if (typeName.equals("Byte") || typeName.equals("byte")) {
                methodTypes[i] = Byte.TYPE;
                argTypes[i] = scanner.nextByte();
            } else if (typeName.equals("BigDecimal")) {
                methodTypes[i] = BigDecimal.class;
                argTypes[i] = scanner.nextBigDecimal();
            }
            i++;
        }

        System.out.println(methodName);
        Method method = c.getMethod(methodName, methodTypes);
        Object ret = method.invoke(object, argTypes);
        if (ret instanceof Void)
            ;
        else {
            System.out.println("Method returned:");
            System.out.println(ret);
        }

        scanner.close();
    }
}
