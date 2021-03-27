<template>
    <section class="cinema-div">
        <div class="header-placeholder" style="height: 81px;" data-v-36ae7e9a=""></div>
        <div class="addFilms-container">
            <!-- 个人中心 start -->
            <Aside></Aside>
            <!-- 个人中心 end -->
            <!-- 添加影片 start -->
            <div class="addFilms-right">
                <div class="addFilms-title">添加影片</div>
                <div class="form-wrapper">
                    <form action="">
                        <div class="select-group" data-before="类型：">
                            <select name="" id="category" class="form-control" v-model="catgoryName">
                                <option value="请选择">请选择</option>
                                <option v-if="conditionList.catInfo" v-for="(cat, index) in conditionList.catInfo" :key="index">{{cat.catName}}</option>
                            </select>
                        </div>
                        <div class="select-group" data-before="区域：">
                            <select name="" id="area" class="form-control" v-model="sourceName">
                                <option value="请选择">请选择</option>
                                <option v-if="conditionList.sourceInfo" v-for="(cat, index) in conditionList.sourceInfo" :key="index">{{cat.sourceName}}</option>
                            </select>
                        </div>
                        <div class="select-group" data-before="年代：">
                            <select name="" id="year" class="form-control" v-model="yearName">
                                <option value="请选择">请选择</option>
                                <option v-if="conditionList.yearInfo" v-for="(cat, index) in conditionList.yearInfo" :key="index">{{cat.yearName}}</option>
                            </select>
                        </div>
                        <div class="input-group" data-before="影片名称：">
                            <input type="text" class="form-control" placeholder="请输入影片名称" v-model="filmName"/>
                        </div>
                        <div class="input-group" data-before="上映时间：">
                            <input type="text" class="form-control" placeholder="请输入影片上映时间" v-model="filmDate"/>
                        </div>
                        <div class="input-group" data-before="影片时长：">
                            <input type="text" class="form-control" placeholder="请输入影片时长" v-model="filmHour"/>
                        </div>
                        <div class="input-group" data-before="上传图片：">
                            <input type="file" class="form-control" placeholder="请上传影片图片"/>
                        </div>
                        <div class="input-group" data-before="影片简介：">
                            <textarea class="form-control" placeholder="请输入影片简介" v-model="filmIntro"/>
                        </div>
                        <div class="btn-group"><a href="javascript:;" class="btn-submit" @click="submitForm">提交</a></div>
                    </form>
                </div>
            </div>
            <!-- 添加影片 end -->
        </div>
    </section>
</template>
<script>
    import Aside from '~/components/profile/aside.vue'
    import { getData } from '../plugins/axios'
    export default {
        head () {
            return {
                title: '添加影片',
                meta: [
                    { hid: '添加影片', name: '添加影片', content: '添加影片' }
                ]
            }
        },
        data () {
            return {
                orderInfo: {},
                catId: 99,
                sourceId: 99,
                yearId: 99,
                conditionList: {},
                catgoryName: '请选择',
                sourceName: '请选择',
                yearName: '请选择',
                filmName: '',
                filmDate: '',
                filmHour: '',
                filmIntro: ''
            }
        },
        components: {
            Aside
        },
        created () {
            this.getConditionList()
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
            getConditionList() {
                let params = {
                    catId: this.catId,
                    sourceId: this.sourceId,
                    yearId: this.yearId
                }
                const _this = this;
                getData(process.env.BASE_URL+'/film/getConditionList', 'get', params).then((res) => {
                    if (res && res.status == 0) {
                        if (res.data) {
                            _this.conditionList = res.data;
                        }
                    }
                }, (err) => {
                    console.log(err);
                })
            },
            submitForm() {
                const params = {
                    catgoryName: this.catgoryName === '请选择' ? '' : this.catgoryName,
                    sourceName: this.sourceName === '请选择' ? '' : this.sourceName,
                    yearName: this.yearName === '请选择' ? '' : this.yearName,
                    filmName: this.filmName
                }
                console.log(params)
            }
        }
    }
</script>
<style lang="scss" scoped>
    .addFilms-container {
        width: 1200px;
        margin: 0 auto;
        position: relative;
        background-color: #fff;
        &:after {
            content: '';
            display: table;
            clear: both;
        }
        .addFilms-right {
            float: left;
            padding-left: 40px;
            width: 922px;
            min-height: 900px;
            .addFilms-title {
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