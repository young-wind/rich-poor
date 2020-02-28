import javax.swing.*;

/**
 * main方法
 *
 * @author WangBingchen
 * @date 2020/2/27 上午  10:29
 */
public class Main {

    public static void main(String[] args) {
        initPanel();
    }

    /**
     * 初始化画布
     */
    private static void initPanel() {
        System.out.println("=====================================================================初始化画布");
        MyPanel p = new MyPanel();
        Thread panelThread = new Thread(p);
        JFrame frame = new JFrame();
        frame.add(p);
        frame.setSize(1100, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelThread.start(); // 开启画布线程，即世界线程
    }

}
