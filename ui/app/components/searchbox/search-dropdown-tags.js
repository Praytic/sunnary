$(documnent).ready(function() {
  var observer = new MutationObserver(function(mutations) {
    mutations.forEach(function(mutationRecord) {
      mutationRecord.appendChild()
    });
  });
  var target = $('.tags-suggestion-list');
  observer.observe(target, { attributes : true, attributeFilter : ['style'] });
});