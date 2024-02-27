import { apiMaterial } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";
export class AdMaterialAPI {
    static getAll() {
        return request({
            method: "GET",
            url: apiMaterial + "/getall",

        });
    }
    static add(data) {
        console.log("value: " + data);
        return request({
            method: "POST",
            url: apiMaterial + "/add",
            data: data,

        })
    }
    static handelDelete(id) {
        return request({
            method: "Delete",
            url: apiMaterial + "/delete/" + id,
        });
    }

    static update(id, data) {
        return request({
            method: "PUT",
            url: apiMaterial + "/update/" + id,
            data: data,
        });
    }
}