import http from "./httpService.js"
import { toast } from "react-toastify";
const baseURL = 'http://localhost:8080/api';

export async function getAllHackathon(callback){
  try{
    const response=await http.get(`${baseURL}/hackathon`);
    callback(response.data);
    // console.log(response.data);
  }catch(err){
    console.log(err);
    toast.error("An unexpected error occured");
  }
}