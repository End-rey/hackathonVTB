import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import NewsService from "../API/NewsService";
import { useFetching } from "../hooks/useFetching";

export default function MainContent({ accountantNews, dirNews }) {
    const navigate = useNavigate();

    return (
        <div className="main-content">
            <div className="glav-buh">
                <h1>Бухгалтер</h1>
                {accountantNews.map((post) => (
                    <h5 key={post.id} onClick={() => navigate("/" + post.id)}>
                        {post.name}{" "}
                    </h5>
                ))}
                <div></div>
            </div>
            <div className="gen-dir">
                <h1>Генеральный директор</h1>
                {dirNews.map((post) => (
                    <h5 key={post.id} onClick={() => navigate("/" + post.id)}>
                        {post.name}{" "}
                    </h5>
                ))}
            </div>
        </div>
    );
}
