import com.qlchat.base.OkHttpHelper;
import com.qlchat.base.RequestParams;
import okhttp3.Response;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2/28/1810:48 AM
 */
@RunWith(Parameterized.class)
public class TopicAddOrUpdateTest {

    private String userId;
    private String liveId;
    public Response response;
    private RequestParams params;
    private static final String INNER_HOST = "http://inner.test1.qlchat.com";


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"1111", "2222"},
                {"3333", "4444"}
        };

        return Arrays.asList(data);
    }

    public TopicAddOrUpdateTest(String userId, String liveId) {
        this.userId = userId;
        this.liveId = liveId;
    }

    @Before
    public void setUp() {
        params = new RequestParams();
    }

    @Test
    public void postApi1() throws IOException {
        // url 配置
        String url = INNER_HOST + "/h5/topic/endTopic1";
        // 请求参数设置
        params.put("userId", userId).put("liveId", liveId);

        String requestBody = params.getRequestBody();
        // 执行请求
        try {
            OkHttpHelper okHttpClient = OkHttpHelper.getInstance();
            response = okHttpClient.post(url, requestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 响应参数
        String responseBody = response.body().string();

        System.out.println("***********Body***********\n"
                + responseBody);

        JSONObject json = new JSONObject(responseBody);
        Object msg = json.getJSONObject("state").get("msg");
        // 断言
        assertEquals("HTTP status code 200", response.code(), 200);

//        assertEquals("msg 信息", msg.toString(), "成功");

    }

    @Test
    public void postApi2() throws IOException {

        String url = INNER_HOST + "/h5/topic/endTopic2";

        params.put("userId", userId).put("liveId", liveId);

        String requestBody = params.getRequestBody();

        try {
            OkHttpHelper okHttpClient = OkHttpHelper.getInstance();
            response = okHttpClient.post(url, requestBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String responseBody = response.body().string();

        System.out.println("***********Body***********\n"
                + responseBody);

        JSONObject json = new JSONObject(responseBody);
        Object msg = json.getJSONObject("state").get("msg");

//        assertEquals("HTTP status code 200", response.code(), 200);
        assertEquals("msg 信息", msg.toString(), "成功");

    }

    @After
    public void tearDown() {
        response.close();
    }

}
