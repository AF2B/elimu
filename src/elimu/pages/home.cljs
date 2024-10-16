(ns elimu.pages.home
  (:require [elimu.components.atomic :as atomic]))

(defn home-page []
  [:div [:h2 "Bem vindo ao Elimu!"]
   [:p "Clique no botão abaixo para ver um alerta."]
   [atomic/alert-button]])