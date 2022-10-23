import axios from "axios";

export default class NewsService {
    static async getNewsByJob(job, time) {
        const response = await axios.get("/news/job/" + job + "&time=" + time);
        return response;
    }

    static async getHeadlineById(id) {
        const response = await axios.get("/news/" + id);
        return response;
    }
}