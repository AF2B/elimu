(ns elimu.components.header.header
  (:require [reagent.core :as r]))

(defn header []
  (let [mobile-menu-open? (r/atom false)]
    (fn []
      [:header.header
       [:div.header-container
        ;; Logo
        [:a.logo {:href "/"}
         [:h1.sitename "LOGO"]]

        ;; Navigation Menu
        [:nav.navmenu {:class (when @mobile-menu-open? "active")}
         [:ul.nav-list
          [:li [:a.active {:href "/"} "Home"]]
          [:li [:a {:href "/parceiros"} "Parceiros"]]
          [:li [:a {:href "/sobre"} "Sobre Nós"]]
          [:li [:a {:href "/contato"} "Contato"]]]

        ;; Mobile Menu Toggle
        [:div.mobile-nav-toggle
         {:on-click #(swap! mobile-menu-open? not)}
         (if @mobile-menu-open? "✕" "☰")]]]])))