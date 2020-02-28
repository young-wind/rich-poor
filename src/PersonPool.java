import java.util.ArrayList;
import java.util.List;

/**
 * @author WangBingchen
 * @date 2020/2/27 上午  10:47
 */
public class PersonPool {

    // 最早成为富人的数量
    private int originalRichManCount;

    // 最早成为穷人的数量
    private int originalPoorCount;

    private static PersonPool personPool = new PersonPool();

    List<Person> personList = new ArrayList<>();

    public static PersonPool getInstance() {
        return personPool;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public int getOriginalRichManCount() {
        return originalRichManCount;
    }

    public int getOriginalPoorCount() {
        return originalPoorCount;
    }

    private PersonPool() {
        for (int i = 0; i < Constants.PERSON_COUNT - 1; i++) {
            personList.add(new Person(i, (10 * i) + 50, 200));
        }
    }

    public void originalRichManCountIncrease() {
        originalRichManCount++;
    }

    public void originalPoorCountIncrease() {
        originalPoorCount++;
    }

}
