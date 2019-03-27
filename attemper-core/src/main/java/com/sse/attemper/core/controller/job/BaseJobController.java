package com.sse.attemper.core.controller.job;

import com.sse.attemper.core.service.job.BaseJobService;
import com.sse.attemper.sdk.common.constant.APIConst;
import com.sse.attemper.sdk.common.constant.APIPath;
import com.sse.attemper.sdk.common.param.dispatch.job.*;
import com.sse.attemper.sdk.common.result.CommonResult;
import com.sse.attemper.sdk.common.result.dispatch.job.BaseJob;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ldang
 */
@Api(tags = APIConst.APITag.JOB)
@RestController
public class BaseJobController {
	
	@Autowired
	private BaseJobService service;

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.ADD)
	@ApiImplicitParam(value = "被新增的数据", name = "saveParam", dataType = "BaseJobSaveParam", required = true)
	@PostMapping(APIPath.JobPath.BasePath.ADD)
	public CommonResult<BaseJob> add(@RequestBody BaseJobSaveParam saveParam) {
		return CommonResult.putResult(service.add(saveParam));
	}

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.UPDATE)
	@ApiImplicitParam(value = "被更新的数据", name = "saveParam", dataType = "BaseJobSaveParam", required = true)
	@PutMapping(APIPath.JobPath.BasePath.UPDATE)
	public CommonResult<BaseJob> update(@RequestBody BaseJobSaveParam saveParam) {
		return CommonResult.putResult(service.update(saveParam));
	}

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.LIST)
	@ApiImplicitParam(value = "查询参数", name = "listParam", dataType = "BaseJobListParam", required = true)
	@GetMapping(APIPath.JobPath.BasePath.LIST)
	public CommonResult<Map<String, Object>> list(BaseJobListParam listParam) {
		return CommonResult.putResult(service.list(listParam));
	}

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.REMOVE)
	@ApiImplicitParam(value = "被删除的主键数组", name = "removeParam", dataType = "BaseJobRemoveParam", required = true)
	@DeleteMapping(APIPath.JobPath.BasePath.REMOVE)
	public CommonResult<Void> remove(@RequestBody BaseJobRemoveParam removeParam) {
		return CommonResult.putResult(service.remove(removeParam));
	}

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.GET)
	@ApiImplicitParam(value = "查询单个对象信息", name = "getParam", dataType = "BaseJobGetParam", required = true)
	@GetMapping(APIPath.JobPath.BasePath.GET)
	public CommonResult<BaseJob> get(BaseJobGetParam getParam) {
		return CommonResult.putResult(service.get(getParam));
	}

	@ApiOperation(APIConst.APIOperation.JobTitle.BaseTitle.PUBLISH)
	@ApiImplicitParam(value = "任务名称列表", name = "param", dataType = "BaseJobPublishParam", required = true)
	@PutMapping(APIPath.JobPath.BasePath.PUBLISH)
	public CommonResult<Void> publish(@RequestBody BaseJobPublishParam param) {
		return CommonResult.putResult(service.publish(param));
	}
}