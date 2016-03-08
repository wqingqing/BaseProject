package retrofit2.covert.fastjson;

import android.os.Debug;

import com.alibaba.fastjson.JSONObject;
import com.drawthink.carcare.utils.DebugLog;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * <b>类名称：</b> FastJsonResponseBodyConverter <br/>
 * <b>类描述：</b> ResponseBody转换器<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:58<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException  {
        DebugLog.wtf("response Value is --->"+value.toString());
        try {
            return JSONObject.parseObject(value.string(), type);
        }finally {
            value.close();
        }

    }
}
