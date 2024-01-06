import org.junit.Test;

public class test {
    @Test
    public void test01() {
        String deptName = "太原xxxxxxx店";
        String lastTwoChars = deptName.substring(deptName.length() - 1);
        System.out.println(lastTwoChars); // 将输出"仓库"
    }

    @Test
    public void test02() {
        String ancestors = "0,100,101,200";
        String[] parts = ancestors.split(",");

        System.out.println("拆分后的新字符串数量为：" + parts.length);
    }

}
