(ns elimu.core
  (:require [reagent.core :as r]
            [reagent.dom :as d]
            [elimu.components.header.header :refer [header]]))

(defn app []
  [:div
   [header]])

(defn mount-root []
  (d/render [app] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))