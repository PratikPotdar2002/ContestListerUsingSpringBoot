import http from "./httpService.js"
import { toast } from "react-toastify";
const baseURL = 'http://localhost:8080/api';

export async function getAllHiring(callback){
  try{
    const response=await http.get(`${baseURL}/hiring`);
    callback(response.data);
    // console.log(JSON.stringify(response.data));
  }catch(err){
    console.log(err);
    toast.error("An unexpected error occured");
  }
}