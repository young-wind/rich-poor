import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 画板
 *
 * @author WangBingchen
 * @date 2020/2/27 上午  10:25
 */
public class MyPanel extends JPanel implements Runnable {

    final Integer lock = 1;

    public MyPanel() {
        super();
        this.setBackground(new Color(0x444444));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        PersonPool personPool = PersonPool.getInstance();
        List<Person> people = personPool.personList;
        for (Person person : people) {
            // 给初代富豪（红）、贫困户（绿）标记颜色
            if (person.isOriginalRichMan()) {
                g.setColor(new Color(0xff0000));
            } else if (person.isOriginalPoor()) {
                g.setColor(new Color(0x00ff00));
            } else {
                g.setColor(new Color(0xdddddd));
            }
            // 玩一下
            person.play(personPool);
            // 绘制“柱状”图
            g.fillOval(person.getX(), person.getY(), 8, 3 * person.getMoney());
        }

        // 排序
        people.sort(Comparator.comparing(Person::getMoney));
        for (int i = 0; i < Constants.PERSON_COUNT - 1; i++) {
            people.get(i).setX((10 * i) + 50);
        }
    }


    public static int worldTime = 0;//世界时间

    public Timer timer = new Timer();

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("=====================================================================重新绘制" + worldTime);
            MyPanel.this.repaint();
            worldTime++;
        }
    }

    @Override
    public void run() {
        System.out.println("=====================================================================时间开始流动");
        timer.schedule(new MyTimerTask(), 0, 100);
    }
}
