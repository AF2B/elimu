(ns elimu.core
  (:require [reagent.core :as r]
            [reagent.dom :as d]
            [elimu.components.header.header :refer [header]]
            [elimu.components.carousel.carousel :refer [carousel]]))

(defn app []
  [:div
   [header]
   [carousel]])

(defn mount-root []
  (d/render [app] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))