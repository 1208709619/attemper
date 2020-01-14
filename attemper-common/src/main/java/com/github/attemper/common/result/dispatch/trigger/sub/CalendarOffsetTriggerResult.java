package com.github.attemper.common.result.dispatch.trigger.sub;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalendarOffsetTriggerResult extends CommonTriggerResult {

    protected String startTimeOfDay;

    protected String timeUnit;

    protected int repeatCount = -1;

    protected int innerOffset;

    protected int outerOffset;

    protected boolean reversed;

}