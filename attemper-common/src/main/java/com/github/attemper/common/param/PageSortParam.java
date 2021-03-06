package com.github.attemper.common.param;

import com.github.attemper.common.constant.CommonConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * page sort param
 */
@Getter
@Setter
@ToString
public class PageSortParam implements CommonParam {

    /**
     * current page
     */
    protected int currentPage;

    /**
     * data size of every page
     */
    protected int pageSize;

    /**
     * sort field
     */
    protected String sort;

    public String validate() {
        if(this.pageSize > CommonConstants.MAX_PAGE_SIZE){
            return "1502";
        }
        return null;
    }

    public void preHandle() {
        //preview handle currentPage
        if(this.currentPage == 0){
            this.currentPage = CommonConstants.DEF_CURRENT_PAGE;
        }
        //preview handle pageSize
        if(this.pageSize == 0){
            this.pageSize = CommonConstants.DEF_PAGE_SIZE;
        } else if (this.pageSize == -1) {
            this.pageSize = CommonConstants.MAX_PAGE_SIZE;
        }
    }

}
