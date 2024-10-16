(ns elimu.core
    (:require
     [reagent.core :as r]
     [reagent.dom :as d]
     [elimu.pages.home :as home]))

;; -------------------------
;; Views

(defn home-page []
  [home/home-page])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
