import { apiColor } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";

export class AdColorAPI{
    static getAll(){
        return request({
            method: "GET",
            url: apiColor +"/getall",
        });
    }

    static add(data){
        console.log("value: " + data); 
        return request({
            method: "POST",
            url: apiColor +"/add",
            data: data,

        })
    }
}
