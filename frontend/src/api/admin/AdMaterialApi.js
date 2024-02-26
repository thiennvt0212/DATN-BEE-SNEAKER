import { apiMaterial } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";
export class AdMaterialAPI  {
    static getAll() {
        return request({
            method: "GET",
            url: apiMaterial +"/getall",
        
        });
}
}