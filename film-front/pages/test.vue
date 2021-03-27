<template>
    <div class="container">
        <div class="table">
            <table>
                <tbody>
                <tr v-for="(item, index) in tableData" :key="index">
                    <td>{{item.date}}</td>
                    <td>{{item.name}}</td>
                    <td>{{item.address}}</td>
                    <td><button type="button" @click="showForm(item)">编辑</button></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="form" v-show="dialogVisible">
            <form  @submit.prevent="submitForm">
                姓名：<input type="text" v-model="addForm.name">
                日期：<input type="text" v-model="addForm.date">
                地址：<input type="text" v-model="addForm.address">
                选择：{{addForm}}
                <select v-model="indexId" id="">
                    <option  v-for="(item, index) in addForm.options"  :key="index" :value=item.label>{{item.label}}</option>
                </select>
                <br>
                <button type="submit">提交</button>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                addForm: {
                    name: '',
                    date: '',
                    address: '',
                    options: [],
                },
                tableData: [
                    {
                        id: '001',
                        date: '2016-05-02',
                        name: '王小虎1',
                        address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                        id: '002',
                        date: '2016-05-04',
                        name: '王小虎2',
                        address: '上海市普陀区金沙江路 1517 弄'
                    }, {
                        id: '003',
                        date: '2016-05-01',
                        name: '王小虎3',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        id: '004',
                        date: '2016-05-03',
                        name: '王小虎4',
                        address: '上海市普陀区金沙江路 1516 弄'
                    }
                ],
                options: [
                    {
                        "indexId":1,
                        "name": "点菜用户数"

                    }, {
                        "indexId":2,
                        "name": "点菜新用户数"
                    }, {
                        "indexId":3,
                        "name": "首次留联系方式人数"
                    }, {
                        "indexId":4,
                        "name": "已有联系方式人数"
                    }
                ],
                indexId: '1'
            }
        },
        methods: {
            showForm(row) {
                this.dialogVisible = true
                this.addForm = {
                    name: row.name,
                    date: row.date,
                    address: row.address,
                    options: this.options
                }
            },
            submitForm() {

            }
        }
    }
</script>

<style lang="scss" scoped>
    .container {
        width: 1000px;
        padding-top: 60px;
        margin: 60px auto;
        .table {
            table {
                width: 100%;
                border-collapse: collapse;
                td {
                    border: 1px solid #eee;
                    text-align: center;
                    padding: 5px 10px;
                }
            }
        }
        .form {
            width: 400px;
            margin: 50px auto;
            input {
                border: 1px solid #eee;
                padding: 5px;
                width: 100%;
            }
            button {
                border: 1px solid #eee;
                border-radius: 4px;
                display: block;
                width: 80px;
                height: 30px;
                line-height: 30px;
                text-align: center;
                margin: 30px auto;
                &:hover {
                    background-color: #eee;
                }
            }
        }
    }
</style>