import com.qlchat.base.ExcelUtils;
import org.junit.Test;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 3/1/182:32 PM
 */
public class RunTestForExcel {

    public static final String FILE_PATH = "src/test/docs/ServiceApiTestCase.xlsx";

    @Test
    public void setUp(){
        ExcelUtils excelUtils = new ExcelUtils(FILE_PATH);
    }

}
