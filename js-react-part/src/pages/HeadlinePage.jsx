import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import NewsService from "../API/NewsService";
import ArrowBtn from "../Components/UI/arrow/ArrowBtn";
import MyButton from "../Components/UI/button/MyButton";
import Loader from "../Components/UI/Loader/Loader";
import { useFetching } from "../hooks/useFetching";

export default function HeadlinePage() {
    const navigate = useNavigate();
    const params = useParams();
    const [headline, setHeadline] = useState({});
    const [fetchPosts, isPostsLoading, postError] = useFetching(async (id) => {
        const response = await NewsService.getHeadlineById(id);
        console.log(response.data);
        setHeadline(response.data);
    });

    useEffect(() => {
        fetchPosts(params.id);
    }, []);

    return (
        <div>
            {isPostsLoading ? (
                <Loader />
            ) : (
                <div>
                    <ArrowBtn onClick={() => navigate("/")} />
                    <div className="headline">
                        <h1>{headline.name}</h1>
                        <div>{headline.description}</div>
                        <a href={headline.url}>Источник</a>
                    </div>
                </div>
            )}
        </div>
    );
}
