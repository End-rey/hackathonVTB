import React, { useEffect, useState } from "react";
import MainContent from "../Components/MainContent";
import Navbar from "../Components/UI/NavBar/Navbar";
import Loader from "../Components/UI/Loader/Loader";
import { useFetching } from "../hooks/useFetching";
import NewsService from "../API/NewsService";

export default function MainPage() {
    const [dirNews, setDirNews] = useState([]);
    const [accountantNews, setAccountantNews] = useState([]);
    const [time, setTime] = useState("day");
    const [fetchPosts, isPostsLoading, postError] = useFetching(async () => {
        const response1 = await NewsService.getNewsByJob('accountant', )
        const response2 = await NewsService.getNewsByJob('director')
        console.log(response1.data);
        setDirNews([response1.data]);
        setAccountantNews([response2.data]);
    });

    useEffect(() => {
        fetchPosts();
    }, []);

    return (
        <div>
            <Navbar />
            {isPostsLoading ? <Loader /> : <MainContent accountantNews={accountantNews} dirNews={dirNews}/>}
        </div>
    );
}
