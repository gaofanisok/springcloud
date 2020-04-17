package com.providertwos.util;

/**
 * @Auther: 分页请求
 * @Date: 2020/4/17 0017 16 00
 * @Description:
 */
public class PageRequest {
        /**
         * 当前页码
         */
        private int pageNum;
        /**
         * 每页数量
         */
        private int pageSize;

        public int getPageNum() {
            return pageNum;
        }
        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }
        public int getPageSize() {
            return pageSize;
        }
        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

}
