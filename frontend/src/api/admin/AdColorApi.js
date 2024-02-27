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
    static handelDelete(id){
        return request({
          method: "Delete",
          url: apiColor + "/delete/" + id,
        });
      }

    //   static getDetail(id) {
    //     return request({
    //         method: "GET",
    //         url: apiColor + "/getDetail/" + id,
    //     });
    // }

    static update(id, data) {
        return request({
            method: "PUT",
            url: apiColor + "/update/" + id,
            data: data,
        });
    }
}
