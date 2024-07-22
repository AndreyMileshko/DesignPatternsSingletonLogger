import java.util.List;

public class Filter {

    private final int thresholdValue;

    public Filter(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        return list.stream()
                .filter(x ->
                {
                    logger.log("Элемент \"" + x + "\"" + (x >= thresholdValue ? " проходит" : " не проходит"));
                    return x >= thresholdValue;
                })
                .toList();
    }
}
