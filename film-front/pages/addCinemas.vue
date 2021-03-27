<template>
    <section class="cinema-div">
        <div class="header-placeholder" style="height: 81px;" data-v-36ae7e9a=""></div>
        <div class="addCinemas-container">
            <!-- 个人中心 start -->
            <Aside></Aside>
            <!-- 个人中心 end -->
            <!-- 我的订单 start -->
            <div class="addCinemas-right" v-if="orderInfo">
                <div class="addCinemas-title">添加影院</div>

                <div class="form-wrapper">
                    <form action="">
                        <div class="select-group" data-before="品牌：">
                            <select name="" id="brand" class="form-control" v-model="brandName">
                                <option value="请选择">请选择</option>
                                <option v-if="cinemaList.brandList" v-for="(cat, index) in cinemaList.brandList" :key="index">{{cat.brandName}}</option>
                            </select>
                        </div>
                        <div class="select-group" data-before="区域：">
                            <select name="" id="area" class="form-control" v-model="areaName">
                                <option value="请选择">请选择</option>
                                <option v-if="cinemaList.areaList" v-for="(cat, index) in cinemaList.areaList" :key="index">{{cat.areaName}}</option>
                            </select>
                        </div>
                        <div class="select-group" data-before="影厅：">
                            <select name="" id="year" class="form-control" v-model="hallName">
                                <option value="请选择">请选择</option>
                                <option v-if="cinemaList.halltypeList" v-for="(cat, index) in cinemaList.halltypeList" :key="index">{{cat.halltypeName}}</option>
                            </select>
                        </div>
                        <div class="input-group" data-before="影院名称：">
                            <input type="text" class="form-control" v-model="cinemaName" placeholder="请输入影院名称"/>
                        </div>
                        <div class="input-group" data-before="影院简介：">
                            <textarea class="form-control" v-model="cinemaIntro" placeholder="请输入影院简介"/>
                        </div>
                        <div class="btn-group"><a href="javascript:;" class="btn-submit" @click="submitForm">提交</a></div>
                    </form>
                </div>
            </div>
            <!-- 我的订单 end -->
        </div>
    </section>
</template>
<script>
    import Aside from '~/components/profile/aside.vue'
    import { getData } from '../plugins/axios'
    export default {
        head () {
            return {
                title: '我的订单',
                meta: [
                    { hid: '我的订单', name: '我的订单', content: '我的订单' }
                ]
            }
        },
        data () {
            return {
                orderInfo: {},
                brandId: 99,//影院编号
                hallType: 99,//影厅类型
                areaId: 99,//行政区编号
                brandName: '请选择',//品牌
                hallName: '请选择',//影厅
                areaName: '请选择',//区域
                cinemaList: {},
                cinemaName: '',
                cinemaIntro: ''
            }
        },
        created () {
            this.getCinemaTags();
        },
        components: {
            Aside
        },
        methods: {
            formatDate(timestamp) {
                var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                var Y = date.getFullYear() + '-';
                var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
                var D = date.getDate() + ' ';
                var h = date.getHours() + ':';
                var m = date.getMinutes() + ':';
                var s = date.getSeconds();
                return Y+M+D+h+m+s;
            },
            getCinemaTags() {
                let _this = this;
                let params = {
                    brandId: this.brandId,//影院编号
                    hallType: this.halltypeId,//影厅类型
                    areaId: this.areaId,//行政区编号
                };
                getData(process.env.BASE_URL + '/cinema/getCondition', 'get', params).then((res) => {
                    if (res && res.status == 0) {
                        _this.cinemaList = res.data;
                    }
                }, (err) => {
                    console.log(err);
                })
            },
            submitForm() {
                const params = {
                    brandName: this.brandName === '请选择' ? '' : this.brandName,
                    hallName: this.hallName === '请选择' ? '' : this.hallName,
                    areaName: this.areaName === '请选择' ? '' : this.areaName,
                    cinemaName: this.cinemaName
                }
                console.log(params)
            }
        }
    }
</script>
<style lang="scss" scoped>
    .addCinemas-container {
        width: 1200px;
        margin: 0 auto;
        position: relative;
        background-color: #fff;
        &:after {
            content: '';
            display: table;
            clear: both;
        }
        .addCinemas-right {
            float: left;
            padding-left: 40px;
            width: 922px;
            min-height: 900px;
            .addCinemas-title {
                padding: 26px 0;
                color: $baseColor;
                font-size: 18px;
                border-bottom: 1px solid #e1e1e1;
                margin-bottom: 30px;
            }
            .form-wrapper {
                .input-group, .select-group {
                    display: table;
                    width: 500px;
                    margin: 10px auto;
                    &:before, .form-control {
                        display: table-cell;
                        vertical-align: middle;
                    }
                    &:before {
                        content: attr(data-before);
                        width: 120px;
                        text-align: right;
                        padding: 6px 12px;
                        font-size: 14px;
                        font-weight: 400;
                        line-height: 1;
                        color: #555;
                        border-radius: 4px;
                    }
                    .form-control {
                        position: relative;
                        z-index: 2;
                        float: left;
                        width: 100%;
                        margin-bottom: 0;
                        height: 34px;
                        padding: 6px 12px;
                        font-size: 14px;
                        line-height: 1.42857143;
                        color: #555;
                        background-color: #fff;
                        background-image: none;
                        border: 1px solid #ccc;
                        border-radius: 4px;
                        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                        -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                        -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                        transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                        &:hover {
                            border-color: $baseColorHover;
                        }
                    }
                }
                .btn-group {
                    position: relative;
                    display: block;
                    text-align: center;
                    .btn-submit {
                        display: inline-block;
                        background-color: #fff;
                        border: 1px solid #ccc;
                        padding: 6px 12px;
                        min-width: 80px;
                        margin-bottom: 0;
                        font-size: 14px;
                        font-weight: 400;
                        line-height: 1.42857143;
                        text-align: center;
                        white-space: nowrap;
                        vertical-align: middle;
                        -ms-touch-action: manipulation;
                        touch-action: manipulation;
                        cursor: pointer;
                        -webkit-user-select: none;
                        -moz-user-select: none;
                        -ms-user-select: none;
                        user-select: none;
                        background-image: none;
                        border-radius: 4px;
                        color: #666;
                        &:hover {
                            border-color: $baseColorHover;
                        }
                    }
                }
            }
        }
    }
</style>