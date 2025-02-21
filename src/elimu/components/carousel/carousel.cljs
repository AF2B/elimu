(ns elimu.components.carousel.carousel
  (:require [reagent.core :as r]))

(def slides
  [{:id 1 
    :image "/api/placeholder/1200/400"
    :title "Primeiro Slide"
    :description "Descrição do primeiro slide"}
   {:id 2 
    :image "/api/placeholder/1200/400"
    :title "Segundo Slide"
    :description "Descrição do segundo slide"}
   {:id 3 
    :image "/api/placeholder/1200/400"
    :title "Terceiro Slide"
    :description "Descrição do terceiro slide"}])

(defn carousel []
  (let [current-slide (r/atom 0)]
    (fn []
      [:div.carousel
       [:div.carousel-inner
        {:style {:transform (str "translateX(" (* -100 @current-slide) "%)")}}
        (for [slide slides]
          ^{:key (:id slide)}
          [:div.carousel-slide
           [:img {:src (:image slide)
                 :alt (:title slide)}]
           [:div.carousel-content
            [:h2 (:title slide)]
            [:p (:description slide)]]])]
       
       [:div.carousel-controls
        [:button.carousel-control.prev
         {:on-click #(swap! current-slide 
                           (fn [curr] (if (zero? curr) 
                                      (dec (count slides)) 
                                      (dec curr))))}
         "←"]
        [:button.carousel-control.next
         {:on-click #(swap! current-slide 
                           (fn [curr] (if (= curr (dec (count slides))) 
                                      0 
                                      (inc curr))))}
         "→"]]
       
       [:div.carousel-indicators
        (for [i (range (count slides))]
          ^{:key i}
          [:button.carousel-indicator
           {:class (when (= i @current-slide) "active")
            :on-click #(reset! current-slide i)}])]])))