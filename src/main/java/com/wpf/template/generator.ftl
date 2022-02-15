package ${packageName};

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pdhy.ajssjg.indicator.BaseIndicatorAction;
import com.pdhy.ajssjg.indicator.IndicatorAction;
import com.pdhy.ajssjg.indicator.IndicatorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
/*
 * @author: wangpf2
 * @datetime: ${currentTime}
 * @description: ${indicatorName}指标action处理类
 */

@Slf4j
@Component
public class ${indicatorClassName} implements BaseIndicatorAction {

    private IndicatorAction indicatorAction = IndicatorAction.getIndicatorAction(
        IndictorConfig.${indicatorConfigClassName}.LABEL,
        IndictorConfig.${indicatorConfigClassName}.CLS,
        IndictorConfig.${indicatorConfigClassName}.ALIAS,
        IndictorConfig.${indicatorConfigClassName}.METHOD_NAME_FOR_TOTAL,
        IndictorConfig.${indicatorConfigClassName}.METHOD_NAME_FOR_DETAIL,
    );

    @Override
    public CompletableFuture getIndicatorAsync(Map<String, Object> args) {
        JSONObject params = JSON.parseObject(JSON.toJSONString(args));
        params.put("startTime", params.get("startTime").toString().replaceAll("-", ""));
        params.put("endTime", params.get("endTime").toString().replaceAll("-", ""));
        CompletableFuture<Object> future = indicatorAction.excuteIndicatorThread(params);
        //子线程执行完成的回调
        future.whenComplete((o, throwable) -> {
            log.info(IndicatorConfig.${indicatorConfigClassName}.LABEL + "查询完成...");
        });
        //子线程发生异常时的回调
        future.exceptionally(throwable -> {
            throwable.printStackTrace();
        });
        return future;
    }

    @Override
    public List<Map<String, Object>> getIndicator(Map<String, Object> args) {
        JSONObject params = JSON.parseObject(JSON.toJSONString(args));
        params.put("startTime", params.get("startTime").toString().replaceAll("-", ""));
        params.put("endTime", params.get("endTime").toString().replaceAll("-", ""));
        List<Map<String, Object>> indicator = indicatorAction.getIndicator(params);
        return indicator;
        }

    @Override
    public void export(Map<String, Object> args, HttpServletResponse response) {
        JSONObject params = JSON.parseObject(JSON.toJSONString(args));
        params.put("startTime", params.get("startTime").toString().replaceAll("-", ""));
        params.put("endTime", params.get("endTime").toString().replaceAll("-", ""));
        List<${exportExcelClassName}> indicator = indicatorAction.getIndicatorDetails(params);
        indicator.download(response,list,${exportExcelClassName}.class );
    }

}