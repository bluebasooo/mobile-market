package ru.bluebasooo.market.mobilemarket.cache.mobile;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.cache.util.FuzzySearchPredictor;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.Filter;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class MobilesCache {
    private final Map<String, Mobile> cache;

    public MobilesCache(List<Mobile> full) {
        this.cache = full.stream().collect(Collectors.toMap(Mobile::getName, element -> element));
    }

    public List<Mobile> findByName(String name) {
        Predicate<String> fuzzyPredictor = new FuzzySearchPredictor(name);

        return cache.entrySet()
                .stream()
                .filter(entry -> fuzzyPredictor.test(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<Mobile> filter(Filter filter) {
        return cache.values()
                .stream()
                .filter(filter::isMatch)
                .toList();
    }

}
