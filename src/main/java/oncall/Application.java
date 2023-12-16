package oncall;

import oncall.controller.OncallController;
import oncall.utils.OncallUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OncallController oncallController = new OncallController();
        oncallController.run();
    }
}
