(ns elimu.components.atomic)

(defn alert-button []
  [:button {:type "button"
            :class "alert-button alert-button-background"
            :onClick #(js/alert "Hello, world!")
            :href "https://github.com/af2b"} "Click me!"])
