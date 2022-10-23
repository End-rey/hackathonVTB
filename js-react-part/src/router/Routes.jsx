import React from 'react'
import { Navigate, useRoutes } from 'react-router-dom'
import HeadlinePage from '../pages/HeadlinePage';
import MainPage from '../pages/MainPage';

export default function Routes() {
  let elements = useRoutes([
    {path: '/', element: <MainPage/>},
    {path: '/:id', element: <HeadlinePage/>},
    { path: "/*", element: <Navigate to="/" replace /> },
  ]);
  return elements;
  
}
