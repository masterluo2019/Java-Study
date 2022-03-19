package com.masterluo.jvm;

/**
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * 方法区内存溢出
 * Created by masterLuo
 * On 2022/2/17
 */
public class MethodSpaceDemo extends ClassLoader {
    public static void main(String[] args) {
//        int j = 0;
//        try {
//            MethodSpaceDemo test = new MethodSpaceDemo();
//            for (int i = 0; i < 10000; i++,j++) {
//                ClassWriter classWriter = new ClassWriter(0);
//                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i,null,"java/lang/Object", null);
//
//                byte[] bytes = classWriter.toByteArray();
//                test.defineClass("Class" + i, bytes, 0, bytes.length);
//            }
//        } finally {
//            System.out.println(j);
//        }
    }
}
