package com.tw;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private Library library;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputStream;


    @Before
    public void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outContent));
    }

    public String systemOut() {
        return outContent.toString();
    }

    public void setInput(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);
        assertEquals(mockedList.get(0), value);
    }


    @Test
    public void testRunMainMenu() throws Exception {

        setInput("3\n");
        library.main();
        String result = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n";
        assertThat(systemOut()).isEqualTo(result);
    }


    @Test
    public void testInput1AndWrong1() {
        String inputString =
                "1\n"
                +"错误输入\n"
                + "张三,1,数学: 75,语文: 95,英语: 80,编程: 80\n"
                +"3\n";
        setInput(inputString);
        library.main();

        String result = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "学生张三的成绩被添加\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n";
        assertThat(systemOut()).isEqualTo(result);
    }



    @Test
    public void testInput1AndRight1() {
        String inputString = "1\n"
                +"张三,1,数学: 75,语文: 95,英语: 80,编程: 80\n"
                +"3\n";
        setInput(inputString);
        library.main();

        String result = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n";
        result += "学生张三的成绩被添加\n";
        result += "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n";

        assertThat(systemOut().endsWith(result)).isTrue();
    }

    @Test
    public void testInput2AndWrong2AndPrintScore(){
        String inputString =
            "1\n"
            + "张三,1,数学: 75,语文: 95,英语: 80,编程: 80\n"
            +"1\n"
            + "李四,2,数学: 85,语文: 80,英语: 70,编程: 90\n"
            +"2\n"
            +"错误输入\n"
            +"1,2,3,4\n"
            +"3\n";
        setInput(inputString);
        library.main();

        String result = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "学生张三的成绩被添加\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "学生李四的成绩被添加\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n" +
                "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.0|330\n" +
                "李四|85|80|70|90|81.0|325\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：655.0\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出请输入你的选择（1～3）：\n";
        assertThat(systemOut()).isEqualTo(result);
    }
}
